package monedas.api.presentacion.controladores;

import java.util.List;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import monedas.api.core.servicios.*;
import monedas.api.dominio.entidades.*;
import monedas.api.dominio.dtos.*;

@RestController
@RequestMapping("/api/monedas")
public class MonedaControlador {

    @Autowired
    private IMonedaServicio servicio;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<Moneda> listar() {
        return servicio.listar();
    }

    @GetMapping(value = "/obtener/{id}")
    public Moneda obtener(@PathVariable int id) {
        return servicio.obtener(id);
    }

    @PostMapping(value = "/")
    public Moneda agregar(@RequestBody Moneda moneda) {
        return servicio.agregar(moneda);
    }

    @PutMapping(value = "/")
    public Moneda modificar(@RequestBody Moneda moneda) {
        return servicio.modificar(moneda);
    }

    @DeleteMapping(value = "/{id}")
    public boolean eliminar(@PathVariable int id) {
        return servicio.eliminar(id);
    }

    @GetMapping(value = "/pais/{nombre}")
    public Moneda buscarPorPais(@PathVariable String nombre) {
        return servicio.buscarPorPais(nombre);
    }

    // ********** Cambios

    @PostMapping(value = "/cambio")
    public Cambio agregarCambio(@RequestBody Cambio cambio) {
        return servicio.agregarCambio(cambio);
    }

    @PutMapping(value = "/cambio")
    public Cambio modificarCambio(@RequestBody Cambio cambio) {
        return servicio.modificarCambio(cambio);
    }

    @DeleteMapping(value = "/cambio/{id}")
    public boolean eliminarCambio(@PathVariable int id) {
        return servicio.eliminarCambio(id);
    }

    @PostMapping(value = "/cambiosporperiodo")
    public List<Cambio> listarPorPeriodo(@RequestBody PeriodoDto periodo) {
        System.out.println(
                "periodo=" + periodo.getDesde() + " " + periodo.getHasta() + " idmoneda=" + periodo.getIdMoneda());

        return servicio.listarPorPeriodo(periodo.getIdMoneda(), periodo.getDesde(), periodo.getHasta());
    }

    @GetMapping(value = "/cambios/{idmoneda}")
    public List<Cambio> listarPorMoneda(@PathVariable int idmoneda) {
        return servicio.listarPorMoneda(idmoneda);
    }

}
