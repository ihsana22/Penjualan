package com.indocyber.penjualan.dto.users;


import com.indocyber.penjualan.validation.Compare;
import com.indocyber.penjualan.validation.UniqueUsername;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Schema(description = "Data Account yang untuk me-register user baru.")
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@Compare(firstField = "password",secondField = "passwordConfirmation",message = "Password is no match")
public class RegisterDTO {
	@Schema(description = "Username maximum 20 characters.")
	@NotBlank(message="Username is required")
	@Size(max=50, message="Username can't be more than 20 characters.")
	@UniqueUsername(message = "Username is already exist in database")
	private String username;

	@Schema(description = "Password yang digunakan untuk register maximum 20 characters.")
	@NotBlank(message="Password is required")
	private String password;

	@Schema(description = "Mengkonfirmasi password baru.")
	@NotBlank(message="Password confirmation is required")
	private String passwordConfirmation;

}
