package students.logic;

public class Group {

    // ���� �� ������
    private int groupId;
    // ���� ��� ������
    private String nameGroup;
    // ���� �������
    private String curator;
    // ���� �������������
    private String speciality;

    // get/set ��� �������
    public String getCurator() {
        return curator;
    }

    public void setCurator(String curator) {
        this.curator = curator;
    }

    // get/set ��� �� ������
    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    // get/set ��� ��� ������
    public String getNameGroup() {
        return nameGroup;
    }

    public void setNameGroup(String nameGroup) {
        this.nameGroup = nameGroup;
    }

    // get/set ��� �������������
    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public String toString() {
        return nameGroup;
    }
}