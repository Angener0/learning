package cn.crabapples.system.dao.jpa;

import cn.crabapples.system.entity.SysMenu;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * TODO 系统菜单持久层
 *
 * @author Mr.He
 * 3/2/20 12:15 AM
 * e-mail crabapples.cn@gmail.com
 * qq 294046317
 * pc-name root
 */
public interface SysMenuRepository extends JpaRepository<cn.crabapples.system.entity.SysMenu, String> {

    List<cn.crabapples.system.entity.SysMenu> findByParentId(String parentId);

    List<SysMenu> findByParentIdIsNull();
}
