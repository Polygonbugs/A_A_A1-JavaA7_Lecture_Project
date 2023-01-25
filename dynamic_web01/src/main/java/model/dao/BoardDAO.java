package model.dao;

import database.connect.OracleConnection;
import model.dto.BoardDTO;
import org.apache.ibatis.session.SqlSession;

import java.util.List;
import java.util.Map;

public class BoardDAO {
    private SqlSession session = OracleConnection.getSqlSession();

    public void commit() {
        session.commit();
    }

    public void rollback() {
        session.rollback();
    }

    public void close() {
        session.close();
    }

    public List<BoardDTO> selectPage(Map<String, Object> page) {
        List<BoardDTO> data = session.selectList("boardMapper.selectPage", page); // namespace.id
        return data;
    }

    public int selectTotalRowCount() {
        int count = session.selectOne("boardMapper.selectTotalRowCount");
        return count;
    }
}
