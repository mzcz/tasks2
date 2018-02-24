package com.crud.tasks.domain;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;


/**
 * QTaskItemDto is a Querydsl query type for TaskItemDto
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QTaskItemDto extends EntityPathBase<TaskItemDto> {

    private static final long serialVersionUID = 1343279520L;

    public static final QTaskItemDto taskItemDto = new QTaskItemDto("taskItemDto");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath name = createString("name");

    public final NumberPath<Integer> quantity = createNumber("quantity", Integer.class);

    public QTaskItemDto(String variable) {
        super(TaskItemDto.class, forVariable(variable));
    }

    public QTaskItemDto(Path<? extends TaskItemDto> path) {
        super(path.getType(), path.getMetadata());
    }

    public QTaskItemDto(PathMetadata<?> metadata) {
        super(TaskItemDto.class, metadata);
    }

}

