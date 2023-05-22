package com.company.taskmanagement.security;

import com.company.taskmanagement.entity.Project;
import com.company.taskmanagement.entity.Task;
import io.jmix.security.model.EntityAttributePolicyAction;
import io.jmix.security.model.EntityPolicyAction;
import io.jmix.security.role.annotation.EntityAttributePolicy;
import io.jmix.security.role.annotation.EntityPolicy;
import io.jmix.security.role.annotation.ResourceRole;
import io.jmix.securityui.role.annotation.MenuPolicy;
import io.jmix.securityui.role.annotation.ScreenPolicy;

import javax.annotation.Nonnull;

@Nonnull
@ResourceRole(name = "TaskCreator", code = "task-creator", scope = "UI")
public interface TaskCreatorRole {
    @MenuPolicy(menuIds = {"tm_Project.browse", "tm_Task.browse"})
    @ScreenPolicy(screenIds = {"tm_Project.browse", "tm_Task.browse", "tm_Task.edit"})
    void screens();

    @EntityAttributePolicy(entityClass = Project.class, attributes = "*", action = EntityAttributePolicyAction.VIEW)
    @EntityPolicy(entityClass = Project.class, actions = EntityPolicyAction.READ)
    void project();

    @EntityAttributePolicy(entityClass = Task.class, attributes = "*", action = EntityAttributePolicyAction.MODIFY)
    @EntityPolicy(entityClass = Task.class, actions = EntityPolicyAction.ALL)
    void task();
}