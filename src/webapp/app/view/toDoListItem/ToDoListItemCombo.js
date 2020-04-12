Ext.define(appName + '.view.toDoListItem.ToDoListItemCombo', {
    extend		: 'Ext.form.field.ComboBox',
    alias		: 'widget.toDoListItemCombo',
    triggerAction:  'all',
    forceSelection: true,
    editable    : false,
    queryMode	: 'local',
    displayField: 'toDoListItemName',
    valueField	: 'toDoListItemId',
    store       : 'ToDoListItems',
    initComponent: function() {

        this.on('added', function(combo, container, pos, eOpts) {
            combo.getStore().load();
        });

        this.callParent(arguments);
    }
});