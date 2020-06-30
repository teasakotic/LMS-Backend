package backend.app.mapper;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.stereotype.Component;

import backend.app.dto.GodinaStudijaDTO;
import backend.app.model.GodinaStudija;

@Component
public class GodinaStudijaMapper implements Mapper<GodinaStudija, GodinaStudijaDTO>{

	@Override
	public GodinaStudijaDTO toDTO(GodinaStudija e) {
		if (e==null) return null;
		
		GodinaStudijaDTO retVal = new GodinaStudijaDTO();
		retVal.setId(e.getId());
		retVal.setDatumPocetka(e.getDatumPocetka());
		retVal.setDatumKraja(e.getDatumKraja());
		retVal.setGodina(e.getGodina());
		retVal.setStudijskiProgramNaziv(e.getStudijskiProgram().getNaziv());
		retVal.setFakultetNaziv(e.getStudijskiProgram().getFakultet().getIme());
		
		return retVal;
	}

	@Override
	public GodinaStudija toEntity(GodinaStudijaDTO edto) {
		return null;
	}

	@Override
	public Collection<GodinaStudijaDTO> toDTO(Collection<GodinaStudija> es) {
		if (es == null) return null;
		
		Collection<GodinaStudijaDTO> ys = new ArrayList<GodinaStudijaDTO>();
		for (GodinaStudija y : es) {
			ys.add(toDTO(y));			
		}		
		return ys;
	}

	@Override
	public Collection<GodinaStudija> toEntityList(Collection<GodinaStudijaDTO> edtos) {
		return null;
	}

}
