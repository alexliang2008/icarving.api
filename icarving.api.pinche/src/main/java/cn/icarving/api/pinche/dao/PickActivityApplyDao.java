package cn.icarving.api.pinche.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cn.icarving.api.pinche.domain.PickActivityApply;

@Repository
public class PickActivityApplyDao extends BaseDao<PickActivityApply> {

	@Autowired
	private SessionFactory sessionFactory;

	public PickActivityApplyDao() {
		super(PickActivityApply.class);
	}

	public List<PickActivityApply> findPickActivityApplyByUser(int uid) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from PickActivityApply where applyUserId = :applyUserId");
		query.setParameter("applyUserId", uid);
		@SuppressWarnings("unchecked")
		List<PickActivityApply> result = query.list();
		return result;
	}

	public List<PickActivityApply> findPickActivityApplyByPickActivity(int pickActivityId) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from PickActivityApply where pickActivityId = :pickActivityId");
		query.setParameter("pickActivityId", pickActivityId);
		@SuppressWarnings("unchecked")
		List<PickActivityApply> result = query.list();
		return result;
	}
}
