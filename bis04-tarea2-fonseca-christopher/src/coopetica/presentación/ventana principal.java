{\rtf1\ansi\ansicpg1252\cocoartf2709
\cocoatextscaling0\cocoaplatform0{\fonttbl\f0\fswiss\fcharset0 Helvetica;}
{\colortbl;\red255\green255\blue255;}
{\*\expandedcolortbl;;}
\margl1440\margr1440\vieww11520\viewh8400\viewkind0
\pard\tx720\tx1440\tx2160\tx2880\tx3600\tx4320\tx5040\tx5760\tx6480\tx7200\tx7920\tx8640\pardirnatural\partightenfactor0

\f0\fs24 \cf0 package coopetica.logica;\
import coopetica.modelo.Asociado;\
import coopetica.datos.AsociadoArchivoDAO;\
import java.util.ArrayList;\
\
public class AsociadoServicio \{\
    private AsociadoArchivoDAO dao = new AsociadoArchivoDAO();\
\
    public String registrarAsociado(String cedula, String nombre, String aportesStr) \{\
        if (cedula.isEmpty() || nombre.isEmpty() || aportesStr.isEmpty()) return "Error: Campos vacios";\
        double aportes = Double.parseDouble(aportesStr);\
        dao.guardarAsociado(new Asociado(cedula, nombre, aportes));\
        return "\'a1Registrado con exito!";\
    \}\
\
    public ArrayList<Asociado> obtenerAsociados() \{ return dao.leerAsociados(); \}\
    public int obtenerCantidadAsociados() \{ return dao.leerAsociados().size(); \}\
    public double obtenerSumaAportes() \{\
        double total = 0;\
        for (Asociado a : dao.leerAsociados()) total += a.getAportes();\
        return total;\
    \}\
    public Asociado buscarPorCedula(String c) \{\
        for (Asociado a : dao.leerAsociados()) if (a.getCedula().equals(c)) return a;\
        return null;\
    \}\
\}}