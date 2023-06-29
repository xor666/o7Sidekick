package com.Mattera.o7sidekick.repository;

import com.Mattera.o7sidekick.entity.Market.Market;
import com.Mattera.o7sidekick.others.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class MarketRepositoryImpl {

     public Market getMarketByID(long ID){
          Market market = null;
          Session session = null;
          try{
               session = HibernateUtil.getSessionFactory().openSession();
               market =session.get(Market.class, ID);
               System.out.println("ca à l'air de marcher");
          }
          catch (Throwable t){
               t.printStackTrace();
          }
          finally {
               if(session != null){
                    session.close();
               }
          }
          return market;
     }

     public void createMarket(Market market){
          Session session=null;
          Transaction tx=null;
          try{
               session = HibernateUtil.getSessionFactory().openSession();
               tx=session.beginTransaction();
               session.persist(market);
               tx.commit();
               session.flush();
          }
          catch (Exception e){
               if (tx!=null){
                    tx.rollback();
               }
               e.printStackTrace();

          }
          finally {
               if (session != null){
                    session.close();
               }
          }


     }
}
