package mybatis.Service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import mybatis.model.ModelArticle;
import mybatis.model.ModelAttachfile;
import mybatis.model.ModelBoard;
import mybatis.model.ModelComments;

public interface IServiceBoard {

    /*
     * 게시판이름 구하기
     */
    public abstract String getBoardName(String boardcd);

    /*
     * 게시판 모델 객체 구하기
     */
    public abstract ModelBoard getBoardOne(String boardcd);
    
    /*
     * 특정 게시판의 총 게시물 갯수 구하기
     */
    public abstract int getBoardTotalRecord(String boardcd, String searchWord);
    
    /*
     * 게시판종류 리스트 구하기
     */
    public abstract List<ModelBoard> getBoardList();
    
    /*
     * 게시판종류 리스트 구하기
     */
    public abstract Map<String, ModelBoard> getBoardListResultMap();
    
    /*
     * 게시판  추가
     */
    public abstract int insertBoard(ModelBoard board);
    
    /*
     * 게시판  수정
     */
    public abstract int updateBoard(ModelBoard updatevalue, ModelBoard searchvalue);
    
    /*
     * 게시판  삭제
     */
    public abstract int deleteBoard(ModelBoard boardcd) ;
    
    /*
     * 
     */
    public abstract List<ModelBoard> getBoardSearch(ModelBoard boardcd);
    
    /*
     * 
     */
    public abstract List<ModelBoard> getBoardPaging(String boardcd, String searchWord,
            int start, int end);
    
    /*
     * 
     */
    public abstract int insertBoardList(List<ModelBoard> list);
    
    
    
    
    
    


	/*
	 * 게시판 목록
	 */
    public List<ModelArticle> getArticleList(String boardCd, String searchWord, int start, int end);

    /*
     * 게시글 상세보기
     */
    public ModelArticle getArticle(int articleNo);

	/*
	 * 특정 게시판의 총 게시물 갯수 구하기
	 */
    public int getArticleTotalRecord(String boardcd, String searchWord);

	/*
	 * 새로운 게시글  추가
	 */
    public int insertArticle(ModelArticle article);

	/*
	 * 게시글 수정
	 */
    public int updateArticle(ModelArticle updateValue, ModelArticle searchValue);

	/*
	 * 게시글 삭제
	 */
    public int deleteArticle(ModelArticle articleno);

	/*
	 * 조회수 증가
	 */
    public int increaseHit(int articleno);

	/*
	 * 다음글 보기
	 */
    public ModelArticle getNextArticle(ModelArticle updateValue, ModelArticle searchValue);

	/*
	 * 이전글 보기
	 */
    public ModelArticle getPrevArticle(ModelArticle updateValue, ModelArticle searchValue);

	/*
	 * 게시글의 첨부 파일 리스트
	 */
    public List<ModelAttachfile> getAttachFileList(int articleno);

    /*
     * 첨부파일
     */
    public ModelAttachfile getAttachFile(ModelAttachfile attachfileno);

    /*
     * 새로운 첨부파일 추가 
     */
    public int insertAttachFile(ModelAttachfile attachFile);

	/*
	 * 첨부파일 삭제
	 */
    public int deleteAttachFile(ModelAttachfile attachfileno);

    /*
     * 게시글의 덧글리스트 구하기
     */
    public List<ModelComments> getCommentList(int articleno);
    
    /*
     * 덧글가져오기
     */
    public ModelComments getComment(int commentno);

	/*
	 * 덧글쓰기
	 */
    public int insertComment(ModelComments comment);

	/*
	 * 덧글수정
	 */
    public int updateComment(ModelComments updateValue, ModelComments searchValue);

	/*
	 * 덧글삭제
	 */
    public int deleteComment(ModelComments board);

    /*
	public int getListNo();
	
	public int getPrevLink();
	
	public int getFirstPage();
	
	public int getLastPage();
	
	public int getNextLink();

	public int[] getPageLinks();

	public PagingHelper getPagingHelper();

	public void setPagingHelper(PagingHelper pagingHelper);
	*/
}
