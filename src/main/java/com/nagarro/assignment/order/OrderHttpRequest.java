package com.nagarro.assignment.order;

public class OrderHttpRequest {
	private String id;
	private String product;
	private String description;
	private String color;
	private String price;
	private String status;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

//	@Override
//	public String toString() {
//		return "OrderHttpRequest [id=" + id + ", product=" + product + ", description=" + description + ", color="
//				+ color + ", price=" + price + ", status=" + status + "]";
//	}
	 @Override
	    public String toString() {
	        StringBuilder stringBuilder = new StringBuilder(getClass().getSimpleName() + "{");

	        // Check each field for non-null values and append them to the string
	        if (id != null) {
	            stringBuilder.append("id='").append(id).append('\'').append(", ");
	        }
	        if (product != null) {
	            stringBuilder.append("product=").append(product).append(", ");
	        }
	        if (description != null) {
	            stringBuilder.append("description=").append(description).append(", ");
	        }
	        if (color != null) {
	            stringBuilder.append("color=").append(color).append(", ");
	        }
	        if (price != null) {
	            stringBuilder.append("price=").append(price).append(", ");
	        }
	        if (status != null) {
	            stringBuilder.append("status=").append(status).append(", ");
	        }

	        // Delete the trailing comma and space if there are non-null fields
	        if (stringBuilder.charAt(stringBuilder.length() - 1) == ' ' && stringBuilder.charAt(stringBuilder.length() - 2) == ',') {
	            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
	            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
	        }

	        stringBuilder.append('}');
	        return stringBuilder.toString();
	    }
	
}
