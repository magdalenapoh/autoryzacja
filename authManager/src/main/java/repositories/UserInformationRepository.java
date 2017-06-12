package repositories;

import domain.UserInformation;

public interface UserInformationRepository {
	
	UserInformation getUserByUsername(String username);
	UserInformation getUserInfo(int index);
	UserInformation createAdmin();
	int getListSize();	
	void addUserToList(UserInformation userInfo);
}
