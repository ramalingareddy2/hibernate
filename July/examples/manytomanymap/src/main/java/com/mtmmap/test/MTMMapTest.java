package com.mtmmap.test;

import java.util.HashMap;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.mtmmap.entities.Player;
import com.mtmmap.entities.Team;
import com.mtmmap.helper.SessionFactoryRegistry;

public class MTMMapTest {
	public static void main(String[] args) {
		SessionFactory sessionFactory = null;
		Transaction transaction = null;
		Session session = null;
		boolean flag = false;
		Team team = null;
		Player player1 = null;
		Player player2 = null;
		Map<String, Player> players = null;

		try {
			sessionFactory = SessionFactoryRegistry.getSessionFactory();
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();

			/*
			 * player1 = new Player("dhoni", 32, "Male"); int player1No = (int)
			 * session.save(player1); System.out.println("player1 : " + player1No); player2
			 * = new Player("Virat", 30, "Male"); int player2No = (int)
			 * session.save(player2); System.out.println("player2 : " + player2No);
			 * 
			 * players = new HashMap<String, Player>(); players.put("MS93833", player1);
			 * players.put("MS93831", player2);
			 * 
			 * team = new Team("Chennai Super Kings", "srinivasan", "flemming");
			 * team.setPlayers(players);
			 * 
			 * int teamNo = (int) session.save(team); System.out.println("teamno : " +
			 * teamNo);
			 */
			team = session.get(Team.class, 1);
			System.out.println(team);

			flag = true;
		} finally {
			if (transaction != null) {
				if (flag) {
					transaction.commit();
				} else {
					transaction.rollback();
				}
				if (session != null) {
					session.close();
				}
			}
		}
	}

}
