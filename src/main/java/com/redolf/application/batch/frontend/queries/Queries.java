package com.redolf.application.batch.frontend.queries;

public class Queries {
    public static String SELECT_ALL_PARAMETERS = "select * from tb_batch_parameters";
    public static String SELECT_ALL_SUMMARY = "select * from tb_summary";
    public  static String SELECT_ALL_SCHEDULE = "select * from tb_schedule_task";

    public static String COUNT_ALL_CSV = "select * from tb_summary where file_type = 'csv'";

    public static String COUNT_ALL_XML = "select * from tb_summary where file_type = 'xml'";

    public static String COUNT_READ_OPERATION = "select * from tb_operations where operation ='0'";

    public static String COUNT_WRITE_OPERATION = "select * from tb_operations where operation ='1'";

    public static String COUNT_SCHEDULE_READ_OPERATION = "select * from tb_operations where operation ='2'";

    public static String COUNT_SCHEDULE_WRITE_OPERATION = "select * from tb_operations where operation ='3'";

    public static String COUNT_SUCCESSFUL_OPERATION = "select * from tb_status where status ='SUCCESSFUL'";

    public static String COUNT_ROLLBACK_OPERATION = "select * from tb_status where status ='ROLLBACK'";

    public static String COUNT_SINGLE_RESOURCES_OPERATION = "select * from tb_category where category_name ='SINGLE'";

    public static String COUNT_MULTIPLE_RESOURCES_OPERATION = "select * from tb_category where category_name ='MULTIPLE'";

    public static String COUNT_ALL_SCHEMAS = "select schema_name from tb_summary";

    public static String COUNT_ALL_TABLE = "select table_name from tb_summary";

    public static String SELECT_ALL_DATASOURCE = "select * from tb_datasource";

}
