package com.common.utils;

import com.ctrip.datasource.configure.DalDataSourceFactory;
import org.codehaus.plexus.util.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.sql.DataSource;
import java.sql.Connection;

public class DataSourceFactory {
    private static Logger logger = LoggerFactory.getLogger(DataSourceFactory.class);
    private DataSource dataSource;

    public DataSourceFactory(){

    }

    /**
     * 根据DB的key-name到titan获得连接信息，创建datasource
     * @param dbKeyName DB key-name
     * @return DataSource
     */
    public DataSource getDataSource(String dbKeyName) {
        if(StringUtils.isBlank(dbKeyName)){
            logger.error("Get datasource failed: The key name can not be empty!");
            return null;
        }
        try {
            String titanServiceURL = ConfigUtil.getInstance().GetConfig("TITANServiceURL");
            if(StringUtils.isBlank(titanServiceURL)){
                logger.error("Get datasource failed: Cannot get the 'TitanServiceURL' !");
                return null;
            }
            this.dataSource  = new DalDataSourceFactory().createDataSource(dbKeyName, titanServiceURL, "100002380");
            //this.dataSource  = new DalDataSourceFactory().createDataSource(dbKeyName, titanServiceURL);
        } catch (Exception e) {
            logger.error("Get datasource exception. ", e);
        }
        return this.dataSource;
    }

    /**
     * 销毁方法，spring关闭时被调用
     */
    public void destroy(){
        if(this.dataSource != null){
            try{
                Connection connection = this.dataSource.getConnection();
                if(connection!=null){
                    connection.close();
                }
            }catch (Exception e){
                logger.error("Close connection exception. ", e);
            }
        }
    }
}

