package com.revature.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;

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
		public List<Reimbursement> findByUserStatus(int author, int statusId) {
			Session ses = HibernateUtil.getSession();
			
			try {
				List<Reimbursement> rList = ses.createQuery("FROM Reimbursement as r"
						+ "LEFT JOIN"
						+ "ReimbursementStatus as rs"
						+ "on r.statusID = rs.statusId"
						+ "WHERE status = " + statusId, Reimbursement.class).list();
				return rList;
			}
			catch(HibernateException e) {
				e.printStackTrace();
			}
			
			return null;
		}
		
		@Override
		public boolean addReimbursement(Reimbursement reimbursement) {
			Session ses = HibernateUtil.getSession();
			
			try {
				ses.save(reimbursement);
				return true;
			}catch (HibernateException e) {
				e.printStackTrace();
				return false;
			}
			
		}
		
		@Override
		public boolean updateReimbursement(Reimbursement r) {
			Session ses = HibernateUtil.getSession();
			try {
				ses.merge(r);
				return true;
			} catch (HibernateException e) {
				e.printStackTrace();
				return false;
			}
		}
}
