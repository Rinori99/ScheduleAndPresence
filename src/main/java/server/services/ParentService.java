package server.services;

import server.models.Parent;

public interface ParentService {

    Parent getParentById(String id);

    void saveParent(String id, String firstName, String lastName, String email);

    void saveParentStudentConnection(String connectionId, String studentId, String parentId);

}
