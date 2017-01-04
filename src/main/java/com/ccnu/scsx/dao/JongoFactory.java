package com.ccnu.scsx.dao;

import com.mongodb.DB;
import com.mongodb.MongoClient;
import com.mongodb.ServerAddress;
import org.jongo.Jongo;
import org.springframework.beans.factory.FactoryBean;

/**
 * Created by xi.jiang on 2015/9/8.
 */
public class JongoFactory implements FactoryBean<Jongo> {

  private String host;
  private String port;
  private String dbName;
  private String user;
  private String pass;

  public JongoFactory() {

  }

  public JongoFactory(String host, String port, String dbName, String user, String pass) {
    this.host = host;
    this.port = port;
    this.dbName = dbName;
    this.user = user;
    this.pass = pass;
  }

  public Jongo getObject() throws Exception {
    ServerAddress serverAddress = new ServerAddress(host, Integer.parseInt(port));
    MongoClient mongoClient = new MongoClient(serverAddress);
    DB db = mongoClient.getDB(dbName);
    db.authenticate(user, pass.toCharArray());

    Jongo jongo = new Jongo(db);
    return jongo;
  }

  public Class<?> getObjectType() {
    return Jongo.class;
  }

  public boolean isSingleton() {
    return true;
  }

}
