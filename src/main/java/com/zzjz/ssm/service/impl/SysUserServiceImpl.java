package com.zzjz.ssm.service.impl;

import com.zzjz.ssm.pojo.SysUser;
import com.zzjz.ssm.service.SysUserService;
import com.zzjz.ssm.util.MyJdbcTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Service
public class SysUserServiceImpl implements SysUserService {

    @Autowired
    MyJdbcTemplate jdbcTemplate;

    public SysUser getById(Long id) {
        String sql = "select sys_user_id,sys_user_login_name,sys_user_real_name " +
                "from sys_user where `sys_user_id` = ?";
        List<SysUser> userList = jdbcTemplate.query(sql, new SysUserMapper(), id);
        if (userList != null && userList.size() > 0) {
            return userList.get(0);
        }
        return null;
    }

    private final class SysUserMapper implements RowMapper {
        @Override
        public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
            SysUser user = new SysUser();
            user.setSysUserId(rs.getLong("sys_user_id"));
            user.setSysUserLoginName(rs.getString("sys_user_login_name"));
            user.setSysUserRealName(rs.getString("sys_user_real_name"));
            return user;
        }
    }

}
