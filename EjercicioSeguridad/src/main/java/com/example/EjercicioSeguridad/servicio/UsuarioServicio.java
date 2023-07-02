
package com.example.EjercicioSeguridad.servicio;


import java.util.List;

import com.example.EjercicioSeguridad.dto.UsuarioRegistroDTO;
import com.example.EjercicioSeguridad.entidad.Usuario;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UsuarioServicio extends UserDetailsService{
    
    public Usuario guardar(UsuarioRegistroDTO registroDTO);
    
    public List<Usuario> listarUsuarios();

}
