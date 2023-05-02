package org.example.helloJpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.time.LocalDateTime;
import java.util.List;

public class JpaMain {
    public static void main(String[] args) {

        EntityManagerFactory emf =  Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();
        try {
            Member member1 = em.find(Member.class, 1L);
            member1.setUsername("hello");
            em.persist(member1);

            Member member2 = em.find(Member.class, 1L);
            member2.setUsername("hello");
            em.persist(member2);

            em.flush();
            em.clear();

            Member m1 = em.find(Member.class, member1.getId());
            Member m2 = em.getReference(Member.class, member2.getId());

            tx.commit();
        }catch (Exception e){
            tx.rollback();
        }finally {
            em.close();

        }
        emf.close();

    }

    private static void  printMember(Member member){
        System.out.println("member= "+member.getUsername());
    }

    private static void printMemberAndTeam(Member member){
        String username = member.getUsername();
        System.out.println("usrname="+username);
        Team team = member.getTeam();
        System.out.println("team = "+ team.getName());
    }

}
