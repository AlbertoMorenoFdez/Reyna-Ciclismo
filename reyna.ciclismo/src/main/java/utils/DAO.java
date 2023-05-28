package utils;

import java.io.BufferedReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public abstract class DAO {
	private static Connection conexion;

	private static Statement conectar() {
		try {
			BufferedReader lector = new BufferedReader(new FileReader("bdconfig.ini"));
			String ip = lector.readLine();
			int puerto = Integer.parseInt(lector.readLine());
			String nombreBD = lector.readLine();
			String user = lector.readLine();
			String password = lector.readLine();
			lector.close();
			conexion = DriverManager.getConnection("jdbc:mysql://" + ip + ":" + puerto + "/" + nombreBD, user,
					password);
			return conexion.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	private static void desconectar(Statement s) {
		try {
			s.close();
			conexion.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static int insertar(String tabla, HashMap<String, Object> columnas) throws SQLException {
		Statement smt = conectar();
		// insert into cliente (email,nombre,contraseña) values ('a@a.a','paco','mer');
		// insert into cliente (email,telefono,contraseña,nombre) values (
		String consulta = "Insert into " + tabla + " (";
		Iterator it = columnas.keySet().iterator();
		while (it.hasNext()) {
			consulta += (String) it.next() + ",";
		}
		consulta = consulta.substring(0, consulta.length() - 1);
		consulta += ") values (";
		it = columnas.values().iterator();
		while (it.hasNext()) {
			Object elemento = it.next();
			if (elemento != null) {
				if (elemento.getClass() != String.class && elemento.getClass() != Character.class) {
					consulta += elemento + ",";
				} else {
					consulta += "'" + (String) elemento + "',";
				}
			} else {
				consulta += "NULL,";
			}
		}
		consulta = consulta.substring(0, consulta.length() - 1);
		consulta += ")";
		
		int ret = smt.executeUpdate(consulta);
		desconectar(smt);
		return ret;
	}

	public static int borrar(String tabla, HashMap<String, Object> columnas) throws SQLException {
		Statement smt = conectar();
		String consulta = "delete from " + tabla + " where ";
		Iterator it = columnas.entrySet().iterator();
		while (it.hasNext()) {
			Entry actual = (Entry) it.next();
			if (actual.getValue().getClass() != String.class && actual.getValue().getClass() != Character.class) {
				consulta += (String) actual.getKey() + "=" + (String) actual.getValue() + " and ";
			} else {
				consulta += (String) actual.getKey() + "='" + (String) actual.getValue() + "' and ";
			}
		}
		consulta = consulta.substring(0, consulta.length() - 5);
		System.out.println(consulta);
		int ret = smt.executeUpdate(consulta);
		desconectar(smt);
		return ret;
	}

//	public static ArrayList<Object> consultar(String tabla, LinkedHashSet<String> columnasSelect,
//			HashMap<String, Object> restricciones) throws SQLException {
//		Statement smt = conectar();
//
//		String query = "select ";
//		Iterator ith = columnasSelect.iterator();
//		while (ith.hasNext()) {
//			query += (String) ith.next() + ",";
//		}
//		query = query.substring(0, query.length() - 1) + " from " + tabla + (restricciones.size() > 0 ? " where " : "");
//		// select email,nombre,password,telefono from cliente where email='asdad' and
//		Iterator itm = restricciones.entrySet().iterator();
//		while (itm.hasNext()) {
//			Entry actual = (Entry) itm.next();
//			if (actual.getValue().getClass() != String.class && actual.getValue().getClass() != Character.class) {
//				query += (String) actual.getKey() + "=" + (String) actual.getValue() + " and ";
//			} else {
//				query += (String) actual.getKey() + "='" + (String) actual.getValue() + "' and ";
//			}
//		}
//		if (restricciones.size() > 0) {
//			query = query.substring(0, query.length() - 5);
//		}
//		System.out.println(query);
//		ResultSet cursor = smt.executeQuery(query);
//		ArrayList<Object> fila = new ArrayList<Object>();
//		while (cursor.next()) {
//			Iterator hsCols = columnasSelect.iterator();
//			while (hsCols.hasNext()) {
//				String nombreCol = (String) hsCols.next();
//				Object Valores = cursor.getObject(cursor.findColumn(nombreCol));
//				if (Valores != null) {
//					if (Valores.getClass() == String.class) {
//						fila.add((String) Valores);
//					} else if (Valores.getClass() == Integer.class) {
//						fila.add((Integer) Valores);
//					} else if (Valores.getClass() == Short.class) {
//						fila.add((Short) Valores);
//					} else if (Valores.getClass() == Float.class) {
//						fila.add((Float) Valores);
//					}
//				} else {
//					fila.add(null);
//				}
//			}
//
//		}
//		desconectar(smt);
//		return fila;
//	}
	
//	public static ArrayList<Object> consultar(String tabla, LinkedHashSet<String> columnasSelect,
//			HashMap<String, Object> restricciones) throws SQLException {
//		Statement smt = conectar();
//
//		String query = "SELECT ";
//		query += String.join(",", columnasSelect);
//		query += " FROM " + tabla;
//
//		if (!restricciones.isEmpty()) {
//			query += " WHERE ";
//			List<String> restriccionesList = new ArrayList<>();
//			for (Map.Entry<String, Object> entry : restricciones.entrySet()) {
//				String key = entry.getKey();
//				Object value = entry.getValue();
//				String restriccion;
//				if (value instanceof String || value instanceof Character) {
//					restriccion = key + "='" + value + "'";
//				} else {
//					restriccion = key + "=" + value;
//				}
//				restriccionesList.add(restriccion);
//			}
//			query += String.join(" AND ", restriccionesList);
//		}
//
//		System.out.println(query);
//		ResultSet cursor = smt.executeQuery(query);
//		ArrayList<Object> fila = new ArrayList<Object>();
//		while (cursor.next()) {
//			for (String nombreCol : columnasSelect) {
//				Object valor = cursor.getObject(nombreCol);
//				fila.add(valor);
//			}
//		}
//
//		desconectar(smt);
//		return fila;
//	}
	
	/*DEL DAO de MIGUEL*/
	public static ArrayList<Object> consultar(String tabla, LinkedHashSet<String> columnasSelect,
			HashMap<String, Object> restricciones) throws SQLException {
		Statement smt = conectar();

		String query = "select ";
		Iterator ith = columnasSelect.iterator();
		while (ith.hasNext()) {
			query += (String) ith.next() + ",";
		}
		query = query.substring(0, query.length() - 1) + " from " + tabla + (restricciones.size() > 0 ? " where " : "");
		
		Iterator itm = restricciones.entrySet().iterator();
		while (itm.hasNext()) {
			Entry actual = (Entry) itm.next();
			if (actual.getValue().getClass() != String.class && actual.getValue().getClass() != Character.class) {
				query += (String) actual.getKey() + "=" + (String) actual.getValue() + " and ";
			} else {
				query += (String) actual.getKey() + "='" + (String) actual.getValue() + "' and ";
			}
		}
//		Iterator<Map.Entry<String, Object>> itr = restricciones.entrySet().iterator();
//		while (itr.hasNext()) {
//		    Map.Entry<String, Object> actual = itr.next();
//		    Object value = actual.getValue();
//		    if (!(value instanceof String) && !(value instanceof Character)) {
//		        query += actual.getKey() + "=" + value + " and ";
//		    } else {
//		        query += actual.getKey() + "='" + value + "' and ";
//		    }
//		}
		if (restricciones.size() > 0) {
			query = query.substring(0, query.length() - 5);
		}
		if(Config.verboseMode) {
			System.out.println(query);
		}
		ResultSet cursor = smt.executeQuery(query);
		ArrayList<Object> fila = new ArrayList<Object>();
		while (cursor.next()) {
			Iterator hscl = columnasSelect.iterator();
			while (hscl.hasNext()) {
				String nombreCl = (String) hscl.next();
				Object valorColumna = cursor.getObject(cursor.findColumn(nombreCl));
				Object valor = null;
				//System.out.println(valorColumna.getClass());   //Sysout para ver la clase de la columna
				if (valorColumna.getClass() == String.class) {
					valor = (String) valorColumna;
				} else if (valorColumna.getClass() == Integer.class) {
					valor = (Integer) valorColumna;
				} else if (valorColumna.getClass() == BigDecimal.class) {
				    valor = ((BigDecimal) valorColumna).floatValue();
				
				}
				fila.add(valor);
			}

		}
		desconectar(smt);
		return fila;
	}
	

	public static int actualizar(String tabla, HashMap<String, Object> datosAModificar,
			HashMap<String, Object> restricciones) throws SQLException {
		String query = "update " + tabla + " set ";
		Iterator itm = datosAModificar.entrySet().iterator();
		while (itm.hasNext()) {
			Entry actual = (Entry) itm.next();
			if (actual.getValue().getClass() != String.class && actual.getValue().getClass() != Character.class) {
				query += actual.getKey() + " = " + actual.getValue() + ",";
			} else {
				query += actual.getKey() + " = '" + actual.getValue() + "',";
			}
		}
//		query = query.substring(0, query.length() - 1) + " where ";
//		Iterator itr = restricciones.entrySet().iterator();
//		if (itr.hasNext()) {
//		    while (itr.hasNext()) {
//		        Entry actual = (Entry) itr.next();
//		        if (actual.getValue().getClass() != String.class && actual.getValue().getClass() != Character.class) {
//		            query += actual.getKey() + " = " + actual.getValue() + " and ";
//		        } else {
//		            query += actual.getKey() + " = '" + actual.getValue() + "' and ";
//		        }
//		    }
//		    query = query.substring(0, query.length() - 5);
//		} else {
//		    query = query.substring(0, query.length() - 6);
//		}
		
		query = query.substring(0, query.length() - 1) + " where ";
		Iterator itr = restricciones.entrySet().iterator();
		while (itr.hasNext()) {
			Entry actual = (Entry) itr.next();
			if (actual.getValue().getClass() != String.class && actual.getValue().getClass() != Character.class) {
				query += actual.getKey() + " = " + actual.getValue() + " and ";
			} else {
				query += actual.getKey() + " = '" + actual.getValue() + "' and ";
			}
		}
		query = query.substring(0, query.length() - 5);

		Statement smt = conectar();
		if(Config.verboseMode) {
			System.out.println(query);
		}
		int ret = smt.executeUpdate(query);
		desconectar(smt);

		return ret;
	}
	
	

}