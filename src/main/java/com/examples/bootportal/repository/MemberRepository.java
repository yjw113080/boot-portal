package com.examples.bootportal.repository;

import com.examples.bootportal.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface MemberRepository extends JpaRepository<Member, Long> {
    public Member findMemberByEmail(String string);

    @Query("select m from Member m join fetch m.roles WHERE m.email = :email")
    public Member getMemberAndRoles(@Param("email") String email);
}
