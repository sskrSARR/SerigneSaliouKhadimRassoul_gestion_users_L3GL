package dao;

import entity.Role;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class RoleImpl implements IRole {

    private DB db = new DB();
    private ResultSet rs;
    private int ok;

    @Override
    public int add(Role role) {
        return 0;
    }

    @Override
    public List<Role> list() {


        List<Role> roles = new ArrayList<>();
        String sql = "SELECT * FROM role";
        try {
            db.initPrepar(sql);
            rs = db.executeSelect();
            while (rs.next()){
                    Role r = new Role();
                r.setId(rs.getInt("id"));
                r.setName(rs.getString("name"));
                roles.add(r);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return roles;
    }


}
