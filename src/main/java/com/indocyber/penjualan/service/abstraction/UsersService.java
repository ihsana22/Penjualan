package com.indocyber.penjualan.service.abstraction;

import com.indocyber.penjualan.dto.users.RegisterDTO;

public interface UsersService {
    boolean checkExistingAccount(String username);

    void registerAccount(RegisterDTO dto);
}
