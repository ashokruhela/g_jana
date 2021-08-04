package in.gurujana.standalone.model;

public class Client {

	private String clientId;
	private String clientName;
	private String clientEmails;
	private String clientTags;
	private String folderName;
	private String status;
	private String createdDate;
	private String createdBy;

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public String getClientEmails() {
		return clientEmails;
	}

	public void setClientEmails(String clientEmails) {
		this.clientEmails = clientEmails;
	}

	public String getClientTags() {
		return clientTags;
	}

	public void setClientTags(String clientTags) {
		this.clientTags = clientTags;
	}

	public String getFolderName() {
		return folderName;
	}

	public void setFolderName(String folderName) {
		this.folderName = folderName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
}
