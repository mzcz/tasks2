select distinct t.id, t.name, t.description, t.data,i.quantity
from task_crud.tasks t join task_crud.item i on t.id = i.task_id;