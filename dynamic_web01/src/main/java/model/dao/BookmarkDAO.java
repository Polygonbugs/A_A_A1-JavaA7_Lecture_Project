package model.dao;

import database.connect.OracleConnection;
import model.dto.BookmarkDTO;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class BookmarkDAO {

    private SqlSession session = OracleConnection.getSqlSession();

    /**
     * 데이터베이스에 저장할 데이터의 식별값을 생성하기 위한 메서드
     * @return id
     */
    public int getId() {
        int id = session.selectOne("bookmarkMapper.getId");
        return id;
    }

    public List<BookmarkDTO> selectAll() {
        List<BookmarkDTO> data = session.selectList("bookmarkMapper.selectAll");
        return data;
    }

    public int insert(BookmarkDTO dto) {
        int count = session.insert("bookmarkMapper.insert", dto);
        return count;
    }

    public void commit() {
        session.commit();
    }

    public void rollback() {
        session.rollback();
    }

    public void close() {
        session.close();
    }

    public BookmarkDTO selectId(int id) {
        BookmarkDTO data = session.selectOne("bookmarkMapper.selectId", id);
        return data;
    }

    public int update(BookmarkDTO dto) {
        int count = session.update("bookmarkMapper.update", dto);
        return count;
    }

    public int delete(BookmarkDTO dto) {
        int count = session.delete("bookmarkMapper.delete", dto);
        return count;
    }


}