/*global qs, qsa, $on, $parent, $live */

(function (window) {
    'use strict';

    /**
     * View that abstracts away the browser's DOM completely.
     * It has two simple entry points:
     *
     *   - bind(eventName, handler)
     *     Takes a todo application event and registers the handler
     *   - render(command, parameterObject)
     *     Renders the given command with the options
     */
    function View(template) {
        this.template = template;

        this.ENTER_KEY = 13;
        this.ESCAPE_KEY = 27;

        this.$todoList = qs('#todo-list');
        this.$todoItemCounter = qs('#todo-count');
        this.$main = qs('#main');
        this.$footer = qs('#footer');
        this.$toggleAll = qs('#toggle-all');
        this.$newTodo = qs('#new-todo');
    }

    View.prototype._setFilter = function (currentPage) {
        qs('#filters .selected').className = '';
        qs('#filters [href="#/' + currentPage + '"]').className = 'selected';
    };

    View.prototype._elementComplete = function (id, completed) {
        var listItem = qs('[data-id="' + id + '"]');

        if (!listItem) {
            return;
        }

        listItem.className = completed ? 'completed' : '';

        // In case it was toggled from an event and not by clicking the checkbox
        qs('input', listItem).checked = completed;
    };

    View.prototype.render = function (viewCmd, parameter) {
        var that = this;
        var viewCommands = {
            showEntries: function () {
                that.$todoList.innerHTML = that.template.show(parameter);
            },
            updateElementCount: function () {
                that.$todoItemCounter.innerHTML = that.template.itemCounter(parameter);
            },
            contentBlockVisibility: function () {
                that.$main.style.display = that.$footer.style.display = parameter.visible ? 'block' : 'none';
            },
            toggleAll: function () {
                that.$toggleAll.checked = parameter.checked;
            },
            setFilter: function () {
                that._setFilter(parameter);
            },
            clearNewTodo: function () {
                that.$newTodo.value = '';
            },
            elementComplete: function () {
                that._elementComplete(parameter.id, parameter.completed);
            }
        };

        viewCommands[viewCmd]();
    };

    View.prototype._itemId = function (element) {
        var li = $parent(element, 'li');
        return parseInt(li.dataset.id, 10);
    };

    View.prototype.bind = function (event, handler) {
        var that = this;
        if (event === 'newTodo') {
            $on(that.$newTodo, 'change', function () {
                handler(that.$newTodo.value);
            });

        } else if (event === 'toggleAll') {
            $on(that.$toggleAll, 'click', function () {
                handler({completed: this.checked});
            });

        } else if (event === 'itemToggle') {
            $live('#todo-list .toggle', 'click', function () {
                handler({
                    id: that._itemId(this),
                    completed: this.checked
                });
            });

        } else if (event === 'deleteItem') {
            $live('#todo-list .delete', 'click', function () {
                console.log('here')
                handler({
                    id: that._itemId(this)
                });
            });
        }
    };

    // Export to window
    window.app = window.app || {};
    window.app.View = View;
}(window));
