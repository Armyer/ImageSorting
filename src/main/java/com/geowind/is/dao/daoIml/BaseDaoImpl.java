package com.geowind.is.dao.daoIml;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import cn.itcast.jdbc.TxQueryRunner;

import com.geowind.is.dao.Dao;
import com.geowind.is.db.JDBCUtils;
import com.geowind.is.exception.DBException;
import com.geowind.is.utils.ReflectionUtils;

public class BaseDaoImpl<T> implements Dao<T> {

	private QueryRunner queryRunner = new QueryRunner();

	private Class<T> clazz;

	// getClass() ���ر�ʾ�� Class ����ʾ��ʵ�壨�ࡢ�ӿڡ��������ͻ� void���ĳ���� Class��
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
			connection = ConnectionContext.getInstance().get();
			preparedStatement = connection.prepareStatement(sql,
					Statement.RETURN_GENERATED_KEYS);
			if (args != null) {
				for (int i = 0; i < args.length; i++) {
					preparedStatement.setObject(i + 1, args[i]);
				}
			}
			preparedStatement.executeUpdate();
			// ȡ������
			resultSet = preparedStatement.getGeneratedKeys();
			if (resultSet.next()) {
				id = resultSet.getLong(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.release(resultSet, preparedStatement);
		}
		return id;
	}

	@Override
	public void update(String sql, Object... args) {

		Connection connection = null;
		try {
			connection = ConnectionContext.getInstance().get();
			preparedStatement = connection.prepareStatement(sql);
			for (int i = 0; i < args.length; i++) {
				preparedStatement.setObject(i + 1, args[i]);
			}
			preparedStatement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			throw new DBException("���ݿ����ʧ�ܣ�");
		} 
	}

	@Override
	public T query(String sql, Object... args) {

		Connection connection = null;
		try {
			connection = ConnectionContext.getInstance().get();
			return queryRunner.query(connection, sql,
					new BeanHandler<T>(clazz), args);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<T> queryForList(String sql, Object... args) {

		Connection connection = null;
		try {
			connection = ConnectionContext.getInstance().get();
			return queryRunner.query(connection, sql, new BeanListHandler<T>(
					clazz), args);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public <V> V getSingleVal(String sql, Object... args) {
		Connection connection = null;
		try {
			connection = ConnectionContext.getInstance().get();
			return (V) queryRunner.query(connection, sql, new ScalarHandler(),
					args);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	// Execute a batch of SQL INSERT, UPDATE, or DELETE queries.
	public void batch(String sql, Object[]... params) {

		Connection connection = null;
		try {
			connection = ConnectionContext.getInstance().get();
			queryRunner.batch(connection, sql, params);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
