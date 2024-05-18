package com.example.effectivetraining.util;

import com.example.effectivetraining.entity.gym.Group;
import com.example.effectivetraining.entity.gym.Youtube;

import java.util.List;
import java.util.Objects;

public class GroupVideoAssociation {
    private List<Group> groups;
    private Youtube commonVideo;

    public GroupVideoAssociation(List<Group> groups, Youtube commonVideo) {
        this.groups = groups;
        this.commonVideo = commonVideo;
    }

    public List<Group> getGroups() {
        return groups;
    }

    public Youtube getCommonVideo() {
        return commonVideo;
    }

    @Override
    public String toString() {
        return "GroupVideoAssociation{" +
                "groups=" + groups +
                ", commonVideo=" + commonVideo +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GroupVideoAssociation that = (GroupVideoAssociation) o;
        return Objects.equals(groups, that.groups) &&
                Objects.equals(commonVideo, that.commonVideo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(groups, commonVideo);
    }

}
