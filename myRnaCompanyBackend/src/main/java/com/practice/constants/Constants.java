package com.practice.constants;

/**
 * @author SAMEER KADGAYE
 * @version 0.1
 * 
 *          Created Date : 28/10/2021
 * 
 *          Updated Date :
 * 
 *          Updated By :
 *
 */
public interface Constants {

	static int SuccessCode = 200;
	static int ErrorCode = 100;

	static String DataSaveSuccess = "Data Saved Successfully";
	static String DataSaveFailed = "Data Saved Failed";

	static String DataUpdateSuccess = "Data Updated Succesfully";
	static String DataUpdateFailed = "Data Update Failed";

	static String DataDeleteSuccess = "Data Deleted Successfully";
	static String DataDeleteFailed = "Data Delete Failed";

	static String DataFetchSuccess = "Data Fetched Successfully";
	static String DataNotFound = "Data Not Found";

	static String DataListFetchSuccess = "Data List Fetched Successfully";
	static String DataListNotFound = "Data List Not Found";

	// District Master Constant
	static String CodeAlreadyPresent = "Code Already Present";
	static String NameAlreadyPresent = "Name Already Present";
	static String ErrorMsg = "Something Went Wrong";

	static String AccountApprove = "Account is Approved";
	
	// Send Mail
	static String SendMail = "Varification Email Send in Registered Email Address.";
	static String EmailAddressWrong = "Email Address Not Found!";
   
//	User Master Constants
	static String UserNameAlreadyPresent = "User Name Already Present";
	static String AccountNotApprove = "Account Not Approved and Forwarded for Modification";
	

}
