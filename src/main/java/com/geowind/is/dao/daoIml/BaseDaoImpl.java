package com.geowind.is.dao.daoIml;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import java.util.logging.SocketHandler;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.geowind.is.dao.Dao;
import com.geowind.is.db.JDBCUtils;
import com.geowind.is.utils.ReflectionUtils;

public class BaseDaoImpl<T> implements Dao<T> {

	private QueryRunner queryRunner = new QueryRunner();

	private Class<T> clazz;

	// getClass() 返回表示此 Class 所表示的实体（类、接口、基本类型或 void）的超类的 Class。
	public BaseDaoImpl() {
		clazz = ReflectionUtils.getSuperGenericType(getClass());
	}

	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;

	@Override
	public long insert(String sql, Object... args) {

		long id = 0;
		Connection connection = null;
		try {
			connection = JDBCUtils.getConnection();
			preparedStatement = connection.prepareStatement(sql,
					Statement.RETURN_GENERATED_KEYS);
			if (args != null) {
				for (int i = 0; i < args.length; i++) {
					preparedStatement.setObject(i + 1, args[i]);
				}
			}
			// 更新操作
			preparedStatement.executeUpdate();
			// 取出生成的主键
			resultSet = preparedStatement.getGeneratedKeys();
			if (resultSet.next()) {
				id = resultSet.getLong(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.release(resultSet, preparedStatement);
			JDBCUtils.release(connection);
		}
		return id;
	}

	@Override
	public void update(String sql, Object... args) {

		Connection connection = null;
		try {
			connection = JDBCUtils.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			for (int i = 0; i < args.length; i++) {
				preparedStatement.setObject(i + 1, args[i]);
			}
			preparedStatement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.release(connection);
		}
	}

	@Override
	public T query(String sql, Object... args) {

		Connection connection = null;
		try {
			connection = JDBCUtils.getConnection();
			return queryRunner.query(connection, sql,
					new BeanHandler<T>(clazz), args);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.release(connection);
		}
		return null;
	}

	@Override
	public List<T> queryForList(String sql, Object... args) {

		Connection connection = null;
		try {
			connection = JDBCUtils.getConnection();
			return queryRunner.query(connection, sql, new BeanListHandler<T>(
					clazz), args);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.release(connection);
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public <V> V getSingleVal(String sql, Object... args) {
		Connection connection = null;
		try {
			connection = JDBCUtils.getConnection();
			return (V) queryRunner.query(connection, sql, new ScalarHandler(),
					args);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.release(connection);
		}
		return null;
	}

	@Override
	public void batch(String sql, Object[]... params) {

		Connection connection = null;
		try {
			connection = JDBCUtils.getConnection();
			queryRunner.batch(connection, sql, params);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.release(connection);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public <V> List<V> getListSingleVal(String sql, Object... args) {
		Connection connection = null;
		try {
			connection = JDBCUtils.getConnection();
			return (List<V>) queryRunner.query(connection, sql, (ResultSetHandler<T>) new SocketHandler(),
					args);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.release(connection);
		}
		return null;
	}
}
