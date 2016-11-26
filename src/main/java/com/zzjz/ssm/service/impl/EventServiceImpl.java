package com.zzjz.ssm.service.impl;
import com.zzjz.ssm.model.page.Pagination;
import com.zzjz.ssm.pojo.EventDetail;
import com.zzjz.ssm.service.EventService;
import com.zzjz.ssm.util.MyJdbcTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * 事件serviceImpl
 * @author fgt
 * @version  2016/4/15.
 */
@Service
@Transactional
public class EventServiceImpl implements EventService {

    Logger logger = LoggerFactory.getLogger(EventServiceImpl.class);

    @Autowired
    MyJdbcTemplate jdbcTemplate;

    @Override
    public Pagination listEventDetail(int pageNo, int pageSize) {
        String sql = "SELECT *," +
                "f.fireman_name as name " +
                "from event_detail ed " +
                "LEFT JOIN fireman f ON ed.fireman_id = f.fireman_id " +
                "WHERE 1 = 1 LIMIT ? , ? ";
        int start = (pageNo - 1) * pageSize;
        List<EventDetail> eventDetailList = jdbcTemplate.query(sql, new EventDetailMapper(), start, pageSize);
        int total = jdbcTemplate.queryForObject("SELECT COUNT(*) FROM event_detail", Integer.class);
        Pagination page = new Pagination(pageNo, pageSize, total, eventDetailList);
        return page;
    }

    @SuppressWarnings("rawtypes")
    private final class EventDetailMapper implements RowMapper {
        @Override
        public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
            EventDetail eventDetail = new EventDetail();
            eventDetail.setDetailId(rs.getInt("detail_id"));
            eventDetail.setEventId(rs.getInt("event_id"));
            eventDetail.setLeftAir(rs.getString("left_air"));
            eventDetail.setDetailTime(rs.getTime("detail_time"));
            eventDetail.setFiremanId(rs.getInt("fireman_id"));
            eventDetail.setName(rs.getString("name"));
            return eventDetail;
        }
    }

}
