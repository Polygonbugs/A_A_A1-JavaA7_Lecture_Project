package model.service;

import java.util.List;

import model.dao.VisitDAO;
import model.dto.VisitDTO;

public class VisitService {

	public boolean add(VisitDTO dto) {
		VisitDAO dao = new VisitDAO();
		int result = dao.insert(dto);
		if(result == 1) {
			return true;
		}
		return false;
	}

	public List<VisitDTO> getList() {
		VisitDAO dao = new VisitDAO();
		List<VisitDTO> dataList = dao.select();
		return dataList;
	}

}
