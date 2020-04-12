Ext.define(appName + '.view.user.ToDoListCombo', {
    extend		: 'Ext.form.field.ComboBox',
    alias		: 'widget.toDoListCombo',
    queryMode	: 'local',
    forceSelection: true,
    editable    : false,
    displayField: 'toDoListName',
    valueField	: 'toDoListId',
    store       : 'ToDoLists',
    initComponent: function() {

        this.callParent(arguments);
    }
});