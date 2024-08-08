package hiber.dao;

import hiber.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.TypedQuery;
import java.util.Collections;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

   @Autowired
   private final SessionFactory sessionFactory;

   public UserDaoImp(SessionFactory sessionFactory) {
      this.sessionFactory = sessionFactory;
   }

   @Override
   @Transactional
   public void add(User user) {
      sessionFactory.getCurrentSession().save(user);
   }

   @Override
   @SuppressWarnings("unchecked")
   @Transactional(readOnly = true)
   public List<User> listUsers() {
      return sessionFactory.getCurrentSession()
              .createQuery("from User u join fetch u.car", User.class)
              .list();
   }

   @Override
   @Transactional(readOnly = true)
   public List<User> getUserByCar(String model, int series) {
      return sessionFactory.getCurrentSession()
              .createQuery("from User u join fetch u.car c where c.model = :model and c.series = :series", User.class)
              .setParameter("model", model)
              .setParameter("series", series)
              .getResultList();
   }


}


