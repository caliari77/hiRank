package com.gameFx.hiRank.bean;

public class ConfigurationConstants {

    private ConfigurationConstants(){}

    //Postgresql
    public static final String DB_DRIVER = "org.postgresql.Driver";
    public static final String APPLICATION_URL = "jdbc:postgresql://localhost:5432/";
    public static final String DB_USER = "postgres";
    public static final String DB_PASSWORD = "admin";
    public static final String DB_DIALECT = "org.hibernate.dialect.PostgreSQLDialect";

    //JPA
    public static final String SHOW_SQL = "hibernate.show_sql";
    public static final String FORMAT_SQL = "hibernate.format_sql";
    public static final String ENTITY_PACKAGE = "com.gameFx.hiRank.model";
    public static final String HIBERNATE_DIALECT = "hibernate.dialect";
    public static final String HIBERNATE_HBM2DLL_AUTO = "hibernate.hbm2ddl.auto";
    public static final String UPDATE = "update";

}
