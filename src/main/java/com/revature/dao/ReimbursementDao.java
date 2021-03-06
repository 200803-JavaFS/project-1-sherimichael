package com.revature.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.models.Reimbursement;
import com.revature.utils.HibernateUtil;

public class ReimbursementDao implements ReimbursementDaoIf {

		public ReimbursementDao() {
			super();
		}
		
		@Override
		public List<Reimbursement> findAll() {
			Session ses = HibernateUtil.getSession();
			
			try {
				@SuppressWarnings("unchecked")
				List<Reimbursement> rList = ses.createQuery("FROM Reimbursement").list();
				return rList;
			}
			catch(HibernateException e) {
				e.printStackTrace();
			}
			return null;
		}
		
		@Override
		public Reimbursement findByRId(int id) {
			Session ses = HibernateUtil.getSession();
			
			try {
				Reimbursement r = ses.get(Reimbursement.class, id);
				return r;
			}
			catch(HibernateException e) {
				e.printStackTrace();
			}
			
			return null;
		}
		
		@Override
		public List<Reimbursement> findByRStatus(int statusId) {
			Session ses = HibernateUtil.getSession();
			
			try {
				List<Reimbursement> rList = ses.createQuery("FROM Reimbursement WHERE statusId = " + statusId, Reimbursement.class).list();
				return rList;
			}
			catch(HibernateException e) {
				e.printStackTrace();
			}
			
			return null;
		}
		
		@SuppressWarnings("unchecked")
		@Override
		public List<Reimbursement> findRByAuthor(int author) {
				
			Session ses = HibernateUtil.getSession();
			List<Reimbursement> tickets = ses.createQuery("FROM Reimbursement WHERE author=" +author).list();
			return tickets;
		}
		
		@Override
		public List<Reimbursement> findByUser(int author) {
			Session ses = HibernateUtil.getSession();
			
			try {
				List<Reimbursement> rList = ses.createQuery("FROM Reimbursement WHERE author = " + author, Reimbursement.class).list();
				return rList;
			}
			catch(HibernateException e) {
				e.printStackTrace();
			}
			
			return null;
		}
		
		@Override
		public boolean addReimbursement(Reimbursement r) {
		
			Session ses = HibernateUtil.getSession();
			try {
			Transaction tx= ses.beginTransaction();
			ses.save(r);
			tx.commit();
			return true;
			
			}catch (HibernateException e) {
				e.printStackTrace();
				return false;
			}
			
		}
	
		@Override
		public boolean updateReimbursement(Reimbursement r) {
			Session ses = HibernateUtil.getSession();
			Transaction tx= ses.beginTransaction();
			try {
			ses.merge(r);
			tx.commit();
			return true;
			
			}catch (HibernateException e) {
				e.printStackTrace();
				return false;
			}
		}

}
