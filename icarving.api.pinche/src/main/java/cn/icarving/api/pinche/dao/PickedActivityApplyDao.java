package cn.icarving.api.pinche.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cn.icarving.api.pinche.domain.PickedActivityApply;

@Repository
public class PickedActivityApplyDao extends BaseDao<PickedActivityApply> {

	@Autowired
	private SessionFactory sessionFactory;

	public PickedActivityApplyDao() {
		super(PickedActivityApply.class);
	}

	public List<PickedActivityApply> findPickedActivityApplyByUser(int uid) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from PickedActivityApply where applyUserId = :applyUserId");
		query.setParameter("applyUserId", uid);
		@SuppressWarnings("unchecked")
		List<PickedActivityApply> result = query.list();
		return result;
	}

	public List<PickedActivityApply> findPickedActivityApplyByPickedActivity(int pickedActivityId) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from PickedActivityApply where pickedActivityId = :pickedActivityId");
		query.setParameter("pickedActivityId", pickedActivityId);
		@SuppressWarnings("unchecked")
		List<PickedActivityApply> result = query.list();
		return result;
	}
}
