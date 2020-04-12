package src.main.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import src.main.model.*;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.io.Serializable;
import java.util.List;

@Repository
public class MainDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    public Object loadObject(Class clazz, Serializable id) {
        return getCurrentSession().load(clazz, id);
    }

    public boolean saveOrUpdateObject(Object object) {
        getCurrentSession().save(object);
        return true;
    }

    public boolean removeObject(User user) {
        getCurrentSession().remove(user);
        return true;
    }

    public List<User> loadUser() {
        Session currentSession = getCurrentSession();
        CriteriaBuilder criteriaBuilder = currentSession.getCriteriaBuilder();
        CriteriaQuery<User> criteriaQuery = criteriaBuilder.createQuery(User.class);
        Root<User> root = criteriaQuery.from(User.class);
        criteriaQuery.select(root);
        Query<User> query = currentSession.createQuery(criteriaQuery);
        List<User> user = query.getResultList();
        return user;
    }


    public List<ToDoList> loadToDoList() {
        CriteriaBuilder criteriaBuilder = getCurrentSession().getCriteriaBuilder();
        CriteriaQuery<ToDoList> criteriaQuery = criteriaBuilder.createQuery(ToDoList.class);
        Root<ToDoList> root = criteriaQuery.from(ToDoList.class);
        criteriaQuery.select(root);
        Query<ToDoList> query = getCurrentSession().createQuery(criteriaQuery);
        List<ToDoList> toDoList = query.getResultList();
        return toDoList;
    }


    public List<ToDoListItem> loadToDoListItem() {
        CriteriaBuilder criteriaBuilder = getCurrentSession().getCriteriaBuilder();
        CriteriaQuery<ToDoListItem> criteriaQuery = criteriaBuilder.createQuery(ToDoListItem.class);
        Root<ToDoListItem> root = criteriaQuery.from(ToDoListItem.class);
        criteriaQuery.select(root);
        Query<ToDoListItem> query = getCurrentSession().createQuery(criteriaQuery);
        List<ToDoListItem> toDoListItem = query.getResultList();
        return toDoListItem;
    }

}
