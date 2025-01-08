package com.spring.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Date;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.spring.dto.bookDTO;


@Controller
@RequestMapping("/test")
public class controller 
{
	String json;	//project02 에서 쓰기위해 전역변수로 선언
	Gson gs = new Gson();	//이것도 또 쓸거라서 올려줌
	
	@GetMapping("/case1")
	public String index()
	{
		System.out.println("/test/case1 in");
		return "index";
	}
	
	@ResponseBody
	@GetMapping("/project01")
	public String project01()
	{	//dto --> JSON
		System.out.println("/test/project01 in");
		bookDTO dto = new bookDTO("자바",21000,"에이콘",670);
		System.out.println(dto.toString());
		json = gs.toJson(dto);
		System.out.println(json);
		
		//return "index";
		return json;
	}
	

	@GetMapping("/project02")
	public String project02()
	{	//JSON --> dto
		System.out.println("/test/project02 in");
		bookDTO dto = gs.fromJson(json, bookDTO.class);	//fromJson : 어떤 문자열을 어떤 객체에 담겠다
		System.out.println(dto.toString());
		//근데 프로젝트1 먼저 실행하고 2 실행해야 함 !!!
		return "index";
	}
	
	@ResponseBody
	@GetMapping("/project03")
	public String project03()
	{	//(여러 dto -> ArrayList) --> JSON
		System.out.println("/test/project03 in");
		bookDTO dto1 = new bookDTO("자바1",21000,"에이콘1",670);
		bookDTO dto2 = new bookDTO("자바2",21000,"에이콘2",670);
		bookDTO dto3 = new bookDTO("자바3",21000,"에이콘3",670);
		
		ArrayList<bookDTO> list = new ArrayList<bookDTO>();
		list.add(dto1);
		list.add(dto2);
		list.add(dto3);
		
		String jsonlist = gs.toJson(list);
		System.out.println("tojson 변환완료 "+jsonlist);
		
		//JSON(ArrayList가 담긴) --> ArrayList<bookDTO> : 두 번 변환해야 함
		//담으려면 일단 담을거부터 만들어둬야함
		ArrayList<bookDTO> jsontolist = gs.fromJson(jsonlist, new TypeToken<ArrayList<bookDTO>>() {}.getType());
		//TypeToken : 안에 뭐 있는지 알려줌 : 1.ArrayList, 2.bookDTO
		//TypeToken 안의 타입을 반환 : getType() : <bookDTO.class> <ArrayList.class>  이거 두 개 반환하는거
		//원래 gs.fromJson(jsonlist, 어떤 형태의 객체로 변경할건지 적어야 함);
		System.out.println("JSON --> ArrayList "+jsontolist);
		
		for(int i=0; i<jsontolist.size(); i++)
		{	//ArrayList 는 그냥 출력못함
			bookDTO tmp = jsontolist.get(i);
			System.out.println(tmp.toString());
		}
		
		for(bookDTO bo : jsontolist)
		{
			System.out.println(bo.toString());
		}
		return jsonlist;
	}
	
	@GetMapping("/project04")
	public String project04()
	{	//JSON --> dto
		System.out.println("/test/project04 in");

		
		JSONObject student1 = new JSONObject();
		student1.put("name", "홍길동");
		student1.put("phone", "010-1111-1111");
		student1.put("address", "서울");
		System.out.println(student1);
		
		JSONObject student2 = new JSONObject();
		student2.put("name", "나길동");
		student2.put("phone", "010-1111-1122");
		student2.put("address", "광주");
		System.out.println(student2);
		
		JSONArray students = new JSONArray();
		students.put(student1);
		students.put(student2);
		System.out.println("students : "+students);
		
		JSONObject object = new JSONObject();
		object.put("students", students);
		System.out.println("JSONObject : "+object);
		System.out.println(object.toString());
		
		return "index";
	}

	@GetMapping("/project05")
	public String project05()
	{	//
		System.out.println("/test/project05 in");
		String client_id = "00000";
		String client_secret = "0000000";
			/*키보드를 통하여 InputStreamReader 클래스를 통해 바이트 단위로 입력받고 라인 단위로 읽기위해서 버퍼 리더를 연결*/
		BufferedReader io = new BufferedReader(new InputStreamReader(System.in));
		try
		{
			System.out.println("주소를 입력하세요 : ");
			
			//Step1 : 파라미터 확보하기 (검색할 주소 한 줄씩 읽어옴)
			String address = io.readLine();
			System.out.println(address);
				/*입력받는 문자열의 공백으로 인해서 데이터를 끝으로 인식하므로(=토큰 하나로 인식) UTF-8로 변경하면 %20 으로 변환됨(-->데이터가 연속될 수 있다)
				  즉, 데이터 토큰이 공백을 통해서 판단됨 */
			String addr = URLEncoder.encode(address, "utf-8");
			System.out.println(addr);
			
			//Step2 : URL 작성하기
			String reqUrl = "https://naveropenapi.apigw.ntruss.com/map-geocode/v2/geocode?query="+addr;
			
			//Step3 : 작성된 URL을 이용하여 커넥션을 생성 - 요청을 발생 시킴
			URL url = new URL(reqUrl);
			HttpURLConnection con = (HttpURLConnection)url.openConnection();
			con.setRequestMethod("GET");
			con.setRequestProperty("x-ncp-apigw-api-key-id", client_id);
			con.setRequestProperty("x-ncp-apigw-api-key", client_secret);
			
			//Step4 : 요청 후 응답 데이터 수신하기
			int responseCode = con.getResponseCode();
			
			BufferedReader br = new BufferedReader(	//오버플로우 방지하기 위해 버퍼 안에 인풋스트림 갖다넣음
													new InputStreamReader(con.getInputStream(), "UTF-8")
													);
			
			//Step5 : 수신한 데이터 문자열 데이터로 변환하기
			String line;
			StringBuffer data = new StringBuffer();
			//JSON을 한 줄씩 읽어서 응답 클래스 안에 한 줄씩 입력함
			while( (line=br.readLine())!=null )
			{
				data.append(line);
			}
			br.close();
			System.out.println(data);
			
			//받아왔으면 이제 하나씩 꺼내쓰기위해 풀어야 함
			System.out.println("json에서 데이터 꺼내기");
			//Step6 : JSON 객체로 변환하기
			JSONTokener tok = new JSONTokener(data.toString());	//Tokener한테 뭐 줘야 해? --> 모든 걸 다 가지고 있는 data
				//JSONTokener : 데이터 단위를 인식시키기 위해 필요
			JSONObject obj = new JSONObject(tok);	//{ }JSON 이거 인식
			System.out.println("status : "+ obj.get("status"));	//object 안에 있는 네모난거 이렇게 가져옴
			
			JSONObject meta =  obj.getJSONObject("meta");	//객체 안에 있는 객체 꺼내는 방법
				// meta : { }	
				//이러면 또 메타안에 있는 네모난거 꺼낼 수 있음
			int totalCount = meta.getInt("totalCount");
			
			JSONArray arr = obj.getJSONArray("addresses");
				//array 안에 객체 있음 --> 어레이리스트에서는 꺼내려면 0번 달라하면 됨
			JSONObject first = (JSONObject)arr.get(0);	//캐스팅 안하면 에러남
			String x = first.getString("x");
			String y = first.getString("y");
			
			System.out.println("x : "+x);
			System.out.println("y : "+y);
			
			//이미지 가져올 준비
			getImage(x,y,addr);	//함수 만들고 호출해주기
			
			//연습하기
			System.out.println("long name 꺼내기");
			//일단 토큰으로 단위인식
			JSONTokener ttok = new JSONTokener(data.toString());
			//단위인식했으면 json 객체하나 인식
			JSONObject oob = new JSONObject(ttok);
			System.out.println("oob : "+oob);
			//그 안에 있는 배열꺼내기
			JSONArray aarr = oob.getJSONArray("addresses");
			//0번째 객체 안에
			JSONObject ob0 = (JSONObject)aarr.get(0);
			//또 배열있다
			JSONArray ae = ob0.getJSONArray("addressElements");
			System.out.println("addressElements : "+ae);
			//7번째 객체 내놔라
			JSONObject ob7 = (JSONObject)ae.get(7);
			//그 안에 또 배열.. 없다
			//JSONArray types = ob7.getJSONArray("types");
			//값 꺼내기
			String ln = ob7.getString("longName");
			System.out.println("longName : "+ln);
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return "index";
	}
	
	//이미지 가져오기
	public void getImage(String x, String y, String addr)
	{
		System.out.println("getImage in");
		//https://naveropenapi.apigw.ntruss.com/map-static/v2/raster?
		//w=300&
		//h=300&
		//center=127.1054221,37.3591614&
		//level=16&  --확대
		//x-ncp-apigw-api-key-id: {API Key ID}' 
		//x-ncp-apigw-api-key: {API Key}'
		addr = URLDecoder.decode(addr);
		System.out.println("addr decode "+addr);
		try 
		{
			//Step1 : URL 작성
			String url = "https://naveropenapi.apigw.ntruss.com/map-static/v2/raster?";
			url += "w=300&h=300&";
			url += "level=16&";
			url += "center="+ x +","+ y +"&";
			String pos = URLEncoder.encode(x+" "+y,"UTF-8");
	        url += "&markers=type:t|size:mid|pos:"+pos+"|label:"+URLEncoder.encode(addr, "UTF-8");
	        System.out.println("getImage - url 작성 : "+url);
	        
	        //Step2 : 요청발생
	        String client_id = "1qjymgijxj";
			String client_secret = "9s1BfibbrF9C85OT1Ng4IUAkAjBHVUEq9DFAS8oH";
			
	        URL ur = new URL(url);
	        HttpURLConnection con = (HttpURLConnection)ur.openConnection();
			con.setRequestMethod("GET");
			con.setRequestProperty("x-ncp-apigw-api-key-id", client_id);
			con.setRequestProperty("x-ncp-apigw-api-key", client_secret);
			
			//Step3 : 데이터 수신
			InputStream is = con.getInputStream();
			//이미지는 바이트 단위이기 때문에 바이트 배열을 사용
			byte[] bytes = new byte[1024];
			
			//파일 이름 짓기
			String imgname = Long.valueOf(new Date().getTime()).toString();
				//원래 순서대로
				//Date dt = new Date();
				//Long lt = dt.getTime();
				//String img = lt.toString();
			System.out.println("imgname : "+imgname);
			
			//파일생성
			File file = new File(imgname + ".jpg");
			file.createNewFile();	//이거 해야 파일 생성
			//writing
			int read = 0;
			OutputStream outputstream = new FileOutputStream(file);
			while( (read=is.read(bytes))!= -1)
			{
				outputstream.write(bytes,0,read);
			}
			System.out.println("파일 다 읽음");
			is.close();	//버퍼 항상 닫아줘야 함
			outputstream.close();
		}
		catch(Exception e) {}
	}
}
