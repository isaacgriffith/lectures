package edu.isu.cs.cs2263.library;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class MemberList {

    private List<Member> members;

    private MemberList() {
        members = new LinkedList<>();
    }

    public static MemberList instance() {
        return Holder.INSTANCE;
    }

    private static final class Holder {
        private static final MemberList INSTANCE = new MemberList();
    }

    public Member search(String memberId) {
        throw new RuntimeException();
    }

    public boolean insertMember(Member member) {
        if (member != null)
            return members.add(member);
        return false;
    }

    public Iterator<Member> getMembers() {
        return members.iterator();
    }
}
