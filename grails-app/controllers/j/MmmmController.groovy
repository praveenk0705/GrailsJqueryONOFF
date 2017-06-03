package j

class MmmmController {
	

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index = {
        redirect(action: "list", params: params)
    }

    def list = {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        [mmmmInstanceList: Mmmm.list(params), mmmmInstanceTotal: Mmmm.count()]
    }

    def create = {
        def mmmmInstance = new Mmmm()
        mmmmInstance.properties = params
        return [mmmmInstance: mmmmInstance]
    }

    def save = {
        def mmmmInstance = new Mmmm(params)
        if (mmmmInstance.save(flush: true)) {
            flash.message = "${message(code: 'default.created.message', args: [message(code: 'mmmm.label', default: 'Mmmm'), mmmmInstance.id])}"
            redirect(action: "show", id: mmmmInstance.id)
        }
        else {
            render(view: "create", model: [mmmmInstance: mmmmInstance])
        }
    }

    def show = {
        def mmmmInstance = Mmmm.get(params.id)
        if (!mmmmInstance) {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'mmmm.label', default: 'Mmmm'), params.id])}"
            redirect(action: "list")
        }
        else {
            [mmmmInstance: mmmmInstance]
        }
    }

    def edit = {
        def mmmmInstance = Mmmm.get(params.id)
        if (!mmmmInstance) {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'mmmm.label', default: 'Mmmm'), params.id])}"
            redirect(action: "list")
        }
        else {
            return [mmmmInstance: mmmmInstance]
        }
    }

    def update = {
        def mmmmInstance = Mmmm.get(params.id)
        if (mmmmInstance) {
            if (params.version) {
                def version = params.version.toLong()
                if (mmmmInstance.version > version) {
                    
                    mmmmInstance.errors.rejectValue("version", "default.optimistic.locking.failure", [message(code: 'mmmm.label', default: 'Mmmm')] as Object[], "Another user has updated this Mmmm while you were editing")
                    render(view: "edit", model: [mmmmInstance: mmmmInstance])
                    return
                }
            }
            mmmmInstance.properties = params
            if (!mmmmInstance.hasErrors() && mmmmInstance.save(flush: true)) {
                flash.message = "${message(code: 'default.updated.message', args: [message(code: 'mmmm.label', default: 'Mmmm'), mmmmInstance.id])}"
                redirect(action: "show", id: mmmmInstance.id)
            }
            else {
                render(view: "edit", model: [mmmmInstance: mmmmInstance])
            }
        }
        else {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'mmmm.label', default: 'Mmmm'), params.id])}"
            redirect(action: "list")
        }
    }

    def delete = {
        def mmmmInstance = Mmmm.get(params.id)
        if (mmmmInstance) {
            try {
                mmmmInstance.delete(flush: true)
                flash.message = "${message(code: 'default.deleted.message', args: [message(code: 'mmmm.label', default: 'Mmmm'), params.id])}"
                redirect(action: "list")
            }
            catch (org.springframework.dao.DataIntegrityViolationException e) {
                flash.message = "${message(code: 'default.not.deleted.message', args: [message(code: 'mmmm.label', default: 'Mmmm'), params.id])}"
                redirect(action: "show", id: params.id)
            }
        }
        else {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'mmmm.label', default: 'Mmmm'), params.id])}"
            redirect(action: "list")
        }
    }
}
