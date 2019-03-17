package org.xworkz.hibernate.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.xworkz.hibernate.dto.MovieReviewDTO;

import com.xworkz.hibernate.util.HibernateUtil;

public class MovieReviewDAO {

	public boolean save(MovieReviewDTO dto) {
		SessionFactory factory = HibernateUtil.getFactory();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();

		try {
			System.out.println("saving dto with session \t" + dto.getName());
			System.out.println("Data "+dto);
			Serializable id=session.save(dto);
			tx.commit();
			MovieReviewDTO dto2=session.get(MovieReviewDTO.class, id);
			System.out.println("My Data is "+dto2);
			System.out.println("saving dto was successfully \t" + dto.getName());
			Query query=session.createQuery("From MovieReviewDTO");
			List<MovieReviewDTO> list=query.list();
			if (list != null) {
				for(MovieReviewDTO reviewDTO: list) {
					System.out.println("Review DTO Is "+reviewDTO);
				}
			}else {
				System.out.println("No List Found..............");
			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("exception saving dto \t" + dto.getName());
		} finally {
			session.close();
			System.out.println("closing only session");
		}
		return false;
	}

}
