package org.example.helloJpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

public class JpaMain {
    public static void main(String[] args) {

        EntityManagerFactory emf =  Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();
        try {
            Member member = new Member();
            member.setUsername("member1");
            member.setHomeaddress(new Address("homeCity", "street", "10000"));

            member.getFavoriteFoods().add("치킨");
            member.getFavoriteFoods().add("족발");
            member.getFavoriteFoods().add("피자");

            member.getAddressHistory().add(new AddressEntity("old1","street","10000"));
            member.getAddressHistory().add(new AddressEntity("old2","street","10000"));

            em.persist(member);

            em.flush();
            em.clear();

//            //값타입은 변하면 안된다.
            Member member1 = em.find(Member.class, member.getId());
//            Address a = member1.getHomeaddress();
//            member1.setHomeaddress(new Address("newOne", a.getStreet(), a.getCity()));
//
//            //치킨 -> 한식
//            member1.getFavoriteFoods().remove("치킨");
//            member1.getFavoriteFoods().add("한식");
//
//            //equals, hashCode 오버라이딩을 제대로 해야하는 이유
//            member1.getAddressHistory().remove(new AddressEntity("old1","street","10000"));
//            member1.getAddressHistory().add(new AddressEntity("NewNew","street","10000"));

            tx.commit();
        }catch (Exception e){
            tx.rollback();
        }finally {
            em.close();

        }
        emf.close();

    }

}
