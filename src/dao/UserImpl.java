package dao;

import entity.User;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserImpl implements IUser{

    private DB db = new DB();
    private ResultSet rs;
    private int ok;

    @Override
    public int add(User user) {
        String sql = "INSERT INTO user VALUES(null, ?, ?, ?, ? )";
        try {
            db.initPrepar(sql);
            db.getPstm().setString(1, user.getEmail());
            db.getPstm().setString(2, user.getPassword());
            db.getPstm().setString(3, user.passwordHash());
            db.getPstm().setInt(4, user.getIdRole());
            ok = db.executeMaj();
            db.closeConnection();
        }catch (Exception e){
            e.printStackTrace();
        }
        return ok;
    }

    @Override
    public List<User> list() {
        List<User> users = new ArrayList<>();
        String sql = "SELECT * FROM user ";
        try {
            db.initPrepar(sql);
            rs = db.executeSelect();
            while (rs.next()){
                    User u = new User();
                u.setId(rs.getInt("id"));
                u.setEmail(rs.getString("email"));
                u.setPassword(rs.getString("password"));
                u.setPasswordHashed(rs.getString("passwordHashed"));
                u.setIdRole(rs.getInt("idRole"));
                users.add(u);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return users;
    }

}
