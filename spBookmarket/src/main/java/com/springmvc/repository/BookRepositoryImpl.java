package com.springmvc.repository;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Repository;
import com.springmvc.domain.Book;

@Repository
public class BookRepositoryImpl implements BookRepository
{
	private List<Book> listOfBooks = new ArrayList<Book>();
	public BookRepositoryImpl() 
	{ 
		System.out.println("북리파지토리 생성자 진입");
		
        Book book1 = new Book("ISBN1234", "C# 교과서", 30000);
        book1.setAuthor("박용준");
        book1.setDescription("C# 교과서는 생애 첫 프로그래밍 언어로 C#을 시작하는 독자를 대상으로 한다. 특히 응용 프로그래머를 위한 C# 입문서로, C#을 사용하여 게임(유니티), 웹, 모바일, IoT 등을 개발할 때 필요한 C# 기초 문법을 익히고 기본기를 탄탄하게 다지는 것이 목적이다.");
        book1.setPublisher("길벗");
        book1.setCategory("IT전문서");
        book1.setUnitsInStock(1000);
        book1.setReleaseDate("2020/05/29");
        Book book2 = new Book("ISBN1235", "Node.js 교과서", 36000);
        book2.setAuthor("조현영");
        book2.setDescription("이 책은 프런트부터 서버, 데이터베이스, 배포까지 아우르는 광범위한 내용을 다룬다. 군더더기 없는 직관적인 설명으로 기본 개념을 확실히 이해하고, 노드의 기능과 생태계를 사용해 보면서 실제로 동작하는 서버를 만들어보자. 예제와 코드는 최신 문법을 사용했고 실무에 참고하거나 당장 적용할 수 있다.");
        book2.setPublisher("길벗");
        book2.setCategory("IT전문서");
        book2.setUnitsInStock(1000);
        book2.setReleaseDate("2020/07/25");
        Book book3 = new Book("ISBN1236", "어도비 XD CC 2020", 25000);
        book3.setAuthor("김두한");
        book3.setDescription("어도비 XD 프로그램을 통해 UI/UX 디자인을 배우고자 하는 예비 디자이너의 눈높이에 맞게 기본적인 도구를 활용한 아이콘 디자인과 웹&앱 페이지 디자인, UI 디자인, 앱 디자인에 애니메이션과 인터랙션을 적용한 프로토타이핑을 학습합니다.");
        book3.setPublisher("길벗");
        book3.setCategory("IT활용서");
        book3.setUnitsInStock(1000);
        book3.setReleaseDate("2019/05/29");

        System.out.println("book1 : "+book1);
        listOfBooks.add(book1);
        listOfBooks.add(book2);
        listOfBooks.add(book3);
    }

	@Override
	public List<Book> getAllBookList() 
	{
		System.out.println("리파지토리 겟올북리스트");
		return listOfBooks;
	}

	@Override
	public List<Book> getBookListByCategory(String category) 
	{
		System.out.println("리파지토리 카테고리 책 목록 가져오기 함수 진입");
		List<Book> booksByCategory = new ArrayList<Book>();
		for(int i=0; i<listOfBooks.size(); i++)
		{
			Book book = listOfBooks.get(i);
			if(category.equalsIgnoreCase(book.getCategory()))
			{	//받아온 카테고리랑 전체 책 하나씩 비교
				System.out.println(i+"번째 책은 "+category+" 카테고리에 포함됨. 리스트에 추가하기");
				booksByCategory.add(book);
			}
		}
		System.out.println("카테고리 검사 종료 -- 함수를 호출한 북 서비스로 돌아갑니다.");
		return booksByCategory;
	}

	@Override
	public Set<Book> getBookListByFilter(Map<String, List<String>> filter) 
	{	//매트리스 변수 활용하여 책 목록 가져오기 함수 작성
		System.out.println("리파지토리 필터로 책 목록 가져오기 함수 진입");
		Set<Book> booksByPublisher = new HashSet<Book>();	//해당 출판사에 해당하는 책 담을 컬렉션프레임워크
		Set<Book> booksByCategory = new HashSet<Book>();	//해당 카테고리에 해당하는 책 담을 컬렉션프레임워크
		
		Set<String> booksByFilter = filter.keySet();	//전달받은 파라미터(맵)의 키 담을 컬렉션프레임워크
		
		for(String key : filter.keySet()) 
		{	//안에 뭐 들어있는지 확인하기 위한 코드 (프로그램 동작에 관여하지는 않음)
             List<String> values = filter.get(key);
             System.out.println("key : "+key+", value : "+values);
        }
		
		if(booksByFilter.contains("publisher"))
		{	// 전달받은 파라미터 키 중에 publisher 가 있다면
			System.out.println("필터에 출판사가 포함되어있다");
			for(int i=0; i<filter.get("publisher").size(); i++)
			{	//키가 가진 value의 갯수만큼 반복
				String publisherName = filter.get("publisher").get(i);	//인덱스 이용해서 하나씩 꺼내서 변수에 담기
				for(int j=0; j<listOfBooks.size(); j++)
				{
					Book book = listOfBooks.get(j);
					
					if(publisherName.equalsIgnoreCase(book.getPublisher()))
					{
						System.out.println(j+ " 출판사 이름이 유효하다");
						booksByPublisher.add(book);
					}
				}
			}
			System.out.println("필터 - 출판사 for문 종료");
		}
		
		if(booksByFilter.contains("category"))
		{
			System.out.println("필터에 출판사가 포함되어있다");
			for(int i=0; i<filter.get("category").size(); i++)
			{
				String category = filter.get("category").get(i);
				List<Book> list = getBookListByCategory(category);
				booksByCategory.addAll(list);
			}
			System.out.println("필터 - 카테고리 for문 종료");
		}
		booksByCategory.retainAll(booksByPublisher);
		System.out.println("필터 함수 종료 -- 함수를 호출한 북 서비스로 돌아갑니다.");
		return booksByCategory;
	}

	
	@Override
	public Book getBookById(String bookId) 
	{
		System.out.println("리파지토리 : getBookById 진입");
		Book bookInfo = null;
		for(int i=0; i<listOfBooks.size(); i++)
		{
			Book book = listOfBooks.get(i);
			if(book != null && book.getBookId()!=null && book.getBookId().equals(bookId))
			{
				bookInfo = book;
				System.out.println("bookInfo = book 실행");
				break;
			}
		}
		if(bookInfo == null)
		{
			throw new IllegalArgumentException("도서 ID가 "+bookId + "인 해당 도서를 찾을 수 없습니다.");
		}
		System.out.println("getBookById 동작완료");
		return bookInfo;
	}

	@Override
	public void setNewBook(Book book) 
	{
		System.out.println("setNewBook 진입");
		listOfBooks.add(book);
		System.out.println("setNewBook 동작완료");
	}

	
}
