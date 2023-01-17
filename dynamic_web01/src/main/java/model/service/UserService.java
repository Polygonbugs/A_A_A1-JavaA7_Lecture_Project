package model.service;

import model.dao.UserDAO;
import model.dto.UserDTO;

public class UserService {

    public int add(UserDTO dto) {
        UserDAO dao = new UserDAO();

        UserDTO data = dao.selectUser(dto);

        if(data == null) {
            int count = dao.insert(dto);
            if(count == 1) {
                dao.commit(); dao.close();
                return 1;
            }
            dao.rollback(); dao.close();
            return -1;
        }
        dao.close();
        return -2;
    }

    public UserDTO login(UserDTO dto) {
        UserDAO dao = new UserDAO();
        UserDTO data = dao.selectUser(dto);

        if(data == null) {
            dao.close();
            return data;
        } else {
            if(data.getPassword().equals(dto.getPassword())) {
                dao.close();
                return data;
            } else {
                dao.close();
                return null;
            }
        }
    }
}
