package com.zzjz.ssm.util;

import org.apache.log4j.Logger;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.*;
import org.springframework.jdbc.support.JdbcUtils;
import org.springframework.util.Assert;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 重载JdbcTempalte，在数据库操作时打印SQL
 */
public class MyJdbcTemplate extends JdbcTemplate {
	private static Logger logger = Logger.getLogger(MyJdbcTemplate.class);

	public <T> T query(PreparedStatementCreator psc,
			final PreparedStatementSetter pss, final ResultSetExtractor<T> rse)
			throws DataAccessException {

		Assert.notNull(rse, "ResultSetExtractor must not be null");
		logger.debug("Executing prepared SQL query");

		return execute(psc, new PreparedStatementCallback<T>() {
			public T doInPreparedStatement(PreparedStatement ps)
					throws SQLException {
				ResultSet rs = null;
				try {
					if (pss != null) {
						pss.setValues(ps);
					}

					if (logger.isDebugEnabled()) {
						logger.debug(ps.toString());
					}

					rs = ps.executeQuery();
					ResultSet rsToUse = rs;
					if (getNativeJdbcExtractor() != null) {
						rsToUse = getNativeJdbcExtractor().getNativeResultSet(
								rs);
					}
					return rse.extractData(rsToUse);
				} finally {
					JdbcUtils.closeResultSet(rs);
					if (pss instanceof ParameterDisposer) {
						((ParameterDisposer) pss).cleanupParameters();
					}
				}
			}
		});
	}

	protected int update(final PreparedStatementCreator psc,
			final PreparedStatementSetter pss) throws DataAccessException {

		logger.debug("Executing prepared SQL update");
		return execute(psc, new PreparedStatementCallback<Integer>() {
			public Integer doInPreparedStatement(PreparedStatement ps)
					throws SQLException {
				try {
					if (pss != null) {
						pss.setValues(ps);
					}

					if (logger.isDebugEnabled()) {
						logger.debug(ps);
					}

					int rows = ps.executeUpdate();
					if (logger.isDebugEnabled()) {
						logger.debug("SQL update affected " + rows + " rows");
					}
					return rows;
				} finally {
					if (pss instanceof ParameterDisposer) {
						((ParameterDisposer) pss).cleanupParameters();
					}
				}
			}
		});
	}
}